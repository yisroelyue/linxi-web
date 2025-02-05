package com.yy.linxiweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.yy.linxiweb.dao.LoveMusicMapper;
import com.yy.linxiweb.po.Music;
import com.yy.linxiweb.dao.MusicMapper;
import com.yy.linxiweb.po.MusicSheet;
import com.yy.linxiweb.service.ILoveMusicService;
import com.yy.linxiweb.service.IMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.linxiweb.service.IMusicSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yueyi
 * @since 2025-01-17
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    @Autowired
    private IMusicSheetService musicSheetService;

    @Autowired
    private LoveMusicMapper loveMusicMapper;

    @Value("${linxi.fileHost}")
    private String fileHost;

    @Value("${linxi.musicDir}")
    private String musicDir;

    @Value("${linxi.projectDir}")
    private String projectDir;

    @Override
    public List<Music> getByIds(List<Integer> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        return this.baseMapper.selectBatchIds(ids);
    }

    @Override
    public List<Music> getBySongSheetId(int id) {
        MusicSheet sheet = musicSheetService.getById(id);
        if (sheet == null) {
            return List.of();
        }
        String musicIdStr = sheet.getMusicIds();
        List<Integer> musicIds = Arrays.stream(musicIdStr.split(","))
                .map(Integer::parseInt) // 将字符串转换为整数
                .toList(); // 收集为一个 List
        LambdaQueryWrapper<Music> musicLambdaQueryWrapper = new LambdaQueryWrapper<>();
        musicLambdaQueryWrapper.in(Music::getId, musicIds);
        return this.baseMapper.selectList(musicLambdaQueryWrapper);
    }

    @Override
    public List<Music> getLoveMusic() {

        return loveMusicMapper.getList();
    }

    @Override
    public void getCoverImgForMusic(Integer id) {
        Music music = this.getById(id);
        if (music == null) {
            return;
        }
        String path = music.getFilePath();
        String url = fileHost + musicDir + path;
        File mp3File = new File(projectDir + path);

        // 检查文件是否存在
        if (!mp3File.exists()) {
            return; // 文件不存在，直接返回
        }

        try {
            // 获取 MP3 文件的封面图
            Optional<byte[]> coverImage = extractCoverImage(mp3File);

            if (coverImage.isPresent()) {
                // 获取封面图
                byte[] imageData = coverImage.get();

                // 获取 MP3 文件所在的目录
                File parentDirectory = mp3File.getParentFile();

                // 创建封面图文件（可以是 cover.jpg）
                File coverImageFile = new File(parentDirectory, mp3File.getName()+".Cover.jpg");

                // 写入封面图数据到文件
                try (FileOutputStream fos = new FileOutputStream(coverImageFile)) {
                    fos.write(imageData);
                    //System.out.println("封面图已保存至：" + coverImageFile.getAbsolutePath());
                    String CoverPath = coverImageFile.getAbsolutePath();
                    music.setIcPath(CoverPath.replace(projectDir,""));
                    this.updateById(music);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("该 MP3 文件没有封面图");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Optional<byte[]> extractCoverImage(File mp3File) throws IOException, UnsupportedTagException, InvalidDataException {
        Mp3File mp3 = new Mp3File(mp3File);

        // 检查文件是否有 ID3v2 标签
        if (mp3.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3.getId3v2Tag();
            // 获取封面图
            byte[] albumImage = id3v2Tag.getAlbumImage();
            return Optional.ofNullable(albumImage);
        }

        return Optional.empty(); // 没有封面图
    }

}

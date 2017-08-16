package com.example.cootek.newfastframe.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by COOTEK on 2017/8/15.
 */

public interface MusicApi {
    /***
     http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.5.6&format=json
     *
     *
     *
     *获取排行榜歌曲
     * @param type 排行榜类型
     * @param size
     * @param offset
     * @return***/
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.billboard.billList")
    public Observable<RankListBean> getRankList(@Query("type") int type, @Query("size") int size, @Query("offset") int offset);


    /**
     * 获取歌手的基本信息
     * @param id  歌手id
     * @return
     */
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.artist.getInfo")
    public Observable<ArtistInfo> getArtistInfo(@Query("tinguid") String id);


    /**
     * 获取歌手的歌曲列表
     * @param id  歌手id
     * @param offset
     * @param limit
     * @return
     */
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.artist.getInfo")
    public Observable<ArtistSongsBean> getArtistSongs(@Query("tinguid") String id, @Query("offset") int offset, @Query("limits") int limit);


    /**
     * 根据songId获取系统推荐的歌曲列表
     * @param songId
     * @param unm
     * @return
     */
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.song.getRecommandSongList")
    public Observable<ArtistSongsBean> getReCommendSongList(@Query("song_id") String songId, @Query("num") int unm);

    /**
     * 获取歌曲的基本信息，包括播放地址和歌词地址
     * @param songId
     * @return
     */
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.song.play")
    public Observable<DownLoadMusicInfo> getDownLoadMusicInfo(@Query("songid") String songId);

    /**
     * 搜索关键词，返回的列表中包含预支相关的歌曲名，歌手名和专辑名
     * @param searchText  关键词
     * @return
     */
    @GET("/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.search.catalogSug")
    public Observable<SearchMusicBean> search(@Query("query") String searchText);

}
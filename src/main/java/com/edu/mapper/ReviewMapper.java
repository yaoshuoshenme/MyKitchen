package com.edu.mapper;

import com.edu.commons.vo.PageVo;
import com.edu.pojo.Review;

import java.util.List;

public interface ReviewMapper {

    int insert(Review record);


    //查看评论详情
    Review selectByRid(Integer id);

    //查看自己的所有评论
    PageVo<Review> selectMyReview(Integer uid);
    //查看指定菜谱评论
    List<Review> selectByMid(Integer mid);
    //查看指定评论的评论
    List<Review> selectAllByRid(Integer rid);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}
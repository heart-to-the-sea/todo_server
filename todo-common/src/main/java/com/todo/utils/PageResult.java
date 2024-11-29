package com.todo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPage;
    private List<T> rows;
}

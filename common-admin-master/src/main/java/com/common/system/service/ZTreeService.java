package com.common.system.service;

import com.common.system.entity.ZTreeNode;

import java.util.List;


public interface ZTreeService {
    List<ZTreeNode> getMenuZTreeNodes();
    String buildZTree( List<ZTreeNode> zTreeNodeList);
}

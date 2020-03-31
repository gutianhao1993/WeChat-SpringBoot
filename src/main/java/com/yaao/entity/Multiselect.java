package com.yaao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * MultiSelect插件实体类(作树形结构)
 *
 * @author GuTianHao
 */
public class Multiselect implements Serializable {

    private static final long serialVersionUID = -498579624077509306L;

    private Long id;
    private String value;
    private Integer NodeType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Multiselect> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNodeType() {
        return NodeType;
    }

    @Override
    public String toString() {
        return "Multiselect{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", NodeType=" + NodeType +
                ", childs=" + childs +
                '}';
    }

    public void setNodeType(Integer nodeType) {
        NodeType = nodeType;
    }

    public List<Multiselect> getChilds() {
        return childs;
    }

    public void setChilds(List<Multiselect> childs) {
        this.childs = childs;
    }
}

package com.ideafix.service;

import com.ideafix.model.pojo.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {

    public Set<Tag> assignTags(Set<Tag> setOfTags);

    public List<Tag> findAll();

    public void deleteTag(String tagName);

    public void clearFreeTags();
}

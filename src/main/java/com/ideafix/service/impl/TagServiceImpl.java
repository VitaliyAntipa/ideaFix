package com.ideafix.service.impl;

import com.ideafix.dao.TagDAO;
import com.ideafix.model.pojo.Tag;
import com.ideafix.service.TagService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagServiceImpl implements TagService {
    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public Set<Tag> assignTags(Set<Tag> setOfTags) {
        Set<Tag> tags = new HashSet<>();

        if (setOfTags.size() == 0) {
            return tags;
        }

        for (Tag tag : setOfTags) {
            if (!tagDAO.existsByName(tag.getName())) {
                tags.add(tagDAO.saveAndFlush(tag));
            } else {
                tags.add(tagDAO.findByName(tag.getName()));
            }
        }

        return tags;
    }

    @Override
    public List<Tag> findAll() {
        return tagDAO.findAll();
    }

    @Override
    public void deleteTag(String tagName) {
        tagDAO.deleteByName(tagName);
    }

    @Override
    public void clearFreeTags() {
        tagDAO.clearFreeTags();
    }
}

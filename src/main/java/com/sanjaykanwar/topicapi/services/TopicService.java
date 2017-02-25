package com.sanjaykanwar.topicapi.services;

import com.sanjaykanwar.topicapi.models.Topic;
import com.sanjaykanwar.topicapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
         List<Topic> topicList = new ArrayList<>();
         topicRepository.findAll().forEach(topicList::add);
         return topicList;
    }

    public Topic getTopic(final String id){
        return topicRepository.findOne(id);
    }

    public void create(Topic topic){
        topicRepository.save(topic);
    }


    public void update(Topic newTopic){
        topicRepository.save(newTopic);
    }


    public void delete(String id){
        topicRepository.delete(id);
    }

}

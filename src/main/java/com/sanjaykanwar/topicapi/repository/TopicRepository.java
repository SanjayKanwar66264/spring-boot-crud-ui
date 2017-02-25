package com.sanjaykanwar.topicapi.repository;

import com.sanjaykanwar.topicapi.models.Topic;
import org.springframework.data.repository.CrudRepository;


public interface TopicRepository extends CrudRepository<Topic, String> {


}

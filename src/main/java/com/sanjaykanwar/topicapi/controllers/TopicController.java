package com.sanjaykanwar.topicapi.controllers;

import com.sanjaykanwar.topicapi.models.Topic;
import com.sanjaykanwar.topicapi.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllTopics(Model model){
        model.addAttribute("topics", topicService.getAllTopics());
        return "topics/list";
    }

    @RequestMapping("/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.getTopic(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createTopic(Model model){
        Topic topic = new Topic();
        model.addAttribute("topic", topic);
        return "topics/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ModelAndView createTopic(@ModelAttribute(value="topic") Topic topic){
        topicService.create(topic);
        return new ModelAndView("redirect:/topics");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView deleteTopic(@PathVariable String id){
        topicService.delete(id);
        return new ModelAndView("redirect:/topics");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/edit")
    public String editTopic(@PathVariable String id, Model model){
        Topic topic =topicService.getTopic(id);
        model.addAttribute("topic", topic);
        return "topics/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView updateTopic(@ModelAttribute("topic") Topic topic){
        topicService.update(topic);
       return new ModelAndView(    "redirect:/topics");
    }
}

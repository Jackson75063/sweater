package ua.jackson.sweater.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.jackson.sweater.domain.Message;
import ua.jackson.sweater.domain.User;
import ua.jackson.sweater.repository.MessageRepository;

import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

@Controller
public class MainController {


    @Autowired
    MessageRepository messageRepo;

    @GetMapping("/")
    public String greeting(Map<String,Object> model){

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object> model){
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages",messages);

        return "main";
    }


    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Map<String,Object> model) {

        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages",messages);
        return  "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        List<Message> messages;
        if(filter != null && !filter.isEmpty())
            messages= messageRepo.findByTag(filter);
        else
            messages = messageRepo.findAll();
        model.put("messages",messages);


        return "main";

    }

}
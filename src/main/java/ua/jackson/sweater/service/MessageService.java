package ua.jackson.sweater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.jackson.sweater.domain.Message;
import ua.jackson.sweater.domain.User;
import ua.jackson.sweater.domain.dto.MessageDto;
import ua.jackson.sweater.repository.MessageRepository;

import javax.persistence.EntityManager;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepo;



    public Page<MessageDto> messageList(Pageable pageable, String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter, pageable, user);
        } else {
            return messageRepo.findAll(pageable, user);
        }
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepo.findByUser(pageable, author, currentUser);
    }
}

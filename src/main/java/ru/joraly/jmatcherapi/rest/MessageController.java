package ru.joraly.jmatcherapi.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.joraly.jmatcherapi.mapper.MessageMapper;
import ru.joraly.jmatcherapi.model.Message;
import ru.joraly.jmatcherapi.model.dto.request.MessageRequest;
import ru.joraly.jmatcherapi.model.dto.response.MessageResponse;
import ru.joraly.jmatcherapi.service.impl.MessageServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageServiceImpl messageService;
    private final MessageMapper messageMapper;

    @Operation(summary = "Get all messages")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all messages")
    @GetMapping
    public ResponseEntity<List<MessageResponse>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        List<MessageResponse> messageResponses = messages.stream()
                .map(messageMapper::objectToResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(messageResponses, HttpStatus.OK);
    }

    @Operation(summary = "Get a message by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the message"),
            @ApiResponse(responseCode = "404", description = "The message was not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getMessageById(@PathVariable Long id) {
        Optional<Message> messageOptional = messageService.getMessageById(id);
        if (messageOptional.isPresent()) {
            MessageResponse messageResponse = messageMapper.objectToResponse(messageOptional.get());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create a new message")
    @ApiResponse(responseCode = "201", description = "Successfully created a new message")
    @PostMapping
    public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest messageRequest) {
        Message message = messageMapper.requestToObject(messageRequest);
        Message createdMessage = messageService.createMessage(message);
        MessageResponse messageResponse = messageMapper.objectToResponse(createdMessage);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a message by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the message"),
            @ApiResponse(responseCode = "404", description = "The message was not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateMessage(@PathVariable Long id, @RequestBody MessageRequest messageRequest) {
        Optional<Message> messageOptional = messageService.getMessageById(id);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessage(messageRequest.getMessage());

            Message updatedMessage = messageService.updateMessage(message);
            MessageResponse messageResponse = messageMapper.objectToResponse(updatedMessage);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete a message by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the message"),
            @ApiResponse(responseCode = "404", description = "The message was not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        Optional<Message> messageOptional = messageService.getMessageById(id);
        if (messageOptional.isPresent()) {
            messageService.deleteMessage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

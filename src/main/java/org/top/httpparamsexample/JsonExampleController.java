package org.top.httpparamsexample;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("json")
public class JsonExampleController {

    // http://localhost:8080/json/send + JSON body
    @PostMapping("send")
    public String sendJson(@RequestBody InputMessage message) {
        String result = "Received message: " + message;
        System.out.println();
        return result;
    }

    @GetMapping("receive")
    public OutputMessage receiveJson() {
        OutputMessage message = new OutputMessage();
        message.setText("Hello from server!");
        message.setTime(LocalDateTime.now());
        return message;
    }

    @PostMapping("send-receive")
    public OutputMessage sendReceiveJson(@RequestBody InputMessage inputMessage) {
        OutputMessage outputMessage = new OutputMessage();
        outputMessage.setText("Hello from server!");
        outputMessage.setTime(LocalDateTime.now());
        outputMessage.setMessage(inputMessage);
        return outputMessage;
    }


    // классы, описывающие данные, передаваемые через JSON

    // InputMessage - класс описывающий входное сообщение
    public static class InputMessage {
        private String text;
        private Integer value;

        public InputMessage() {}

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[InputMessage] text: " + text + "; value: " + value;
        }
    }

    // OutputMessage - класс, опиывающий выходное сообщениее
    public static class OutputMessage {
        private String text;
        private LocalDateTime time;
        private InputMessage message;

        public OutputMessage() {}

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public InputMessage getMessage() {
            return message;
        }

        public void setMessage(InputMessage message) {
            this.message = message;
        }
    }
}

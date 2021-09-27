package org.example;

import javafx.scene.chart.ScatterChart;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoBot extends TelegramLongPollingBot {

    public void onUpdateReceived(final Update update) {

        final String messageTextReceived = update.getMessage().getText();

        final long chatId = update.getMessage().getChatId();

        SendMessage message = procesarMensaje(String.valueOf(chatId), messageTextReceived);

        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "DaniAres_bot";
    }

    @Override
    public String getBotToken() {
        return "2001682891:AAFgVXnByAdmn68RCjibu0pJhoZRYytZd3o";
    }

    private SendMessage procesarMensaje(String chatId, String texto) {

        SendMessage message = new SendMessage();
        message.setText("Me has dicho : " +texto);
        message.setChatId(String.valueOf(chatId));

        return message;
    }



}

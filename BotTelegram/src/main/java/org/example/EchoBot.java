package org.example;

import javafx.scene.chart.ScatterChart;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;

public class EchoBot extends TelegramLongPollingBot {

    HashMap <String, String> ultimoMensaje = new HashMap<>();

    public void onUpdateReceived(final Update update) {
        //Se obtiene el mensaje
        final Message messageReceived = update.getMessage();

        final long chatId = update.getMessage().getChatId();

        SendMessage message = procesarMensaje(String.valueOf(chatId), messageReceived);

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

    private SendMessage procesarMensaje(String chatId, Message mensaje) {

        SendMessage message = new SendMessage();
        switch (mensaje.getText()) {
            case "/start":
                message.setText("Bienvenido "+mensaje.getFrom().getFirstName()+"\nPulse /ayuda si desea más información");
                break;
            case "/ayuda":
                message.setText("Has usado el comando de ayuda\n"+"El comando /start le dará la bienvenida\n"+"El comando /hora le mostrará la fecha actual\n"
                        +"El comando /miNombre le devolverá su nombre de usuario\n"+"El comando /ultimoMensaje le mostrará el último mensaje enviado\n");
                break;
            case "/hora":
                DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                message.setText("Hoy es "+dtf4.format(LocalDateTime.now()));
                break;
            case "/miNombre":
                message.setText(mensaje.getFrom().getFirstName());
                break;
            case "/ultimoMensaje":
                message.setText("Su último mensaje ha sido : "+ultimoMensaje.get(chatId));
                break;
            default:
                message.setText(mensaje.getText());
                break;
        }

        //message.setText("Me has dicho : " + texto + "\nPulse /ayuda si desea más información");

        message.setChatId(String.valueOf(chatId));

        ultimoMensaje.put(chatId, mensaje.getText());
        return message;
    }

}

/**
 * 
 */
package main;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

/**
 * @author Zuhriddin
 *
 */
public class Main {

	
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot((LongPollingBot) new TranslatorBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	

}

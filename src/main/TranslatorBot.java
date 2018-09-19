/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.gson.Gson;

import result.Entries;
import result.Examples;
import result.LexicalEntries;
import result.Pronunciations;
import result.Response;
import result.Results;
import result.Senses;



/**
 * @author Zuhriddin
 *
 */
public class TranslatorBot extends TelegramLongPollingBot{
	private static String BOT_USERNAME = "fbenglish_translator_bot";
	private static String BOT_TOKEN = "674254977:AAFKJoHBC-fvYxAIZhij7okb8EgnMpPqln4";

	private static String app_id = "29c6dcc4";
	private static String app_key = "236d496a6649d71a0d303acd78c0cdff";

	String url = "";

	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}

	@Override
	public void onUpdateReceived(Update update) {
		String message = null;

		if (update.hasMessage()) {
			message = update.getMessage().getText();
			long chatId = update.getMessage().getChatId();

			if (message.equals("/start")) {
				try {
					execute(sendWelcomeMessage(chatId));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else {
				try {
					execute(sendTranslationMessage(message, chatId));
					execute(sendAudio(url, chatId));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
		}

	}

	private SendMessage sendWelcomeMessage(long chatId) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(
				"Welcome to Online English Translator!" + "\n" + "In order to use this bot, just send english word "
						+ "and immiadetely you will get definition and mp3 file of this word!");
		sendMessage.setChatId(chatId);

		return sendMessage;

	}

	private SendMessage sendTranslationMessage(String message, long chatId) {

		StringBuffer buff = getTranslation(message);

		Gson gson = new Gson();
		Response response = gson.fromJson(buff.toString(), Response.class);

		Results[] results = response.getResults();
		LexicalEntries[] lexicalEntries = results[0].getLexicalEntries();
		Entries[] entries = lexicalEntries[0].getEntries();
		Pronunciations[] pronunciations = lexicalEntries[0].getPronunciations();
		Senses[] senses = entries[0].getSenses();
		String[] definitions = senses[0].getDefinitions();
		Examples[] examples = senses[0].getExamples();

		url = pronunciations[0].getAudioFile();
		// System.out.println(pronunciations[0].getAudioFile());
		//

		StringBuilder builder = new StringBuilder();

		builder.append(response.getMetadata().getProvider()).append(System.lineSeparator()).append("Definition:")
				.append(System.lineSeparator());

		for (String d : definitions) {
			builder.append("- ").append(d).append(System.lineSeparator());
		}
		builder.append("Example:").append(System.lineSeparator());

		for (Examples s : examples) {
			builder.append("- ").append(s.getText()).append(System.lineSeparator());
		}
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(builder.toString());
		sendMessage.setChatId(chatId);

		return sendMessage;
	}


	private SendAudio sendAudio(String url, long chatId) {

		SendAudio sendAudio = new SendAudio();
		sendAudio.setAudio(url);
		sendAudio.setChatId(chatId);

		return sendAudio;
	}

	private String buildURL(String word) {
		final String language = "en";
		final String word_id = word.toLowerCase();
		return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
	}

	public StringBuffer getTranslation(String link) {

		String inputLine = null;
		StringBuffer response = null;

		try {

			URL url = new URL(buildURL(link));
			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Accept", "application/json");
			urlConnection.setRequestProperty("app_id", app_id);
			urlConnection.setRequestProperty("app_key", app_key);

			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;

	}

	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}

}

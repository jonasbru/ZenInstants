package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.messagesviews.MessageImageView;
import com.majomi.zeninstants.messagesviews.MessageSoundView;
import com.majomi.zeninstants.messagesviews.MessageTextView;
import com.majomi.zeninstants.messagesviews.MessageVideoView;
import com.majomi.zeninstants.messagesviews.MessageView;

/**
 * 
 * Manage sets of messages
 * Singleton
 *
 */
public class Message_Manager {

	private ArrayList<MessageView> messages;
	static private Message_Manager messageManager = null;
	
	public ArrayList <MessageView> getMessages()
	{
		return messages;
	}
	
	public Message_Manager()
	{
		messages = new ArrayList<MessageView>();
		messages.add(new MessageTextView("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageView("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageVideoView("video", "letras random sin significado aparente"));
	 	messages.add(new MessageSoundView("elem1", "elem2"));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e "));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
	}
	
	/**
	 * Default constructor with some values ( i > 3 )
	 */
	public Message_Manager(int i)
	{
		messages = new ArrayList<MessageView>();
		messages.add(new MessageTextView("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageView("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageVideoView("video", "letras random sin significado aparente"));	
	 	messages.add(new MessageSoundView("elem1", "elem2"));
	 	messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit. 5   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e Lorem ipsum dolor sit amet, consectetur adipiscing elit. dddddddddddddd   zefuhze fz fiuzeh fiuzez ziu hziuf ziu fz zufu ziu ziufze zei iuezfh zeiufh zhf zfu zifh ziufhziu fh ziuf z fzzehf zif zzf ziefh zfiueh zefh zfih ziefh zeiuf zeif ez ji oerfjj eirj eirne erio ef eof eoifh eorif eziofj eio e io ergioerhgoiezgiuh eeg ezog herugi erigh ieg erg zeiug eri er gezri gezrg zerg ezr  ezrg erigo oerzghzerg hzeiorugerz ezrg zer giezorhguiezrghughgioegh eg erzuezrigh ergh erg ezrg zeiorgh ezriou  uzeorig ezioghze gezir eziurg hzerhldfhjg gnke zrhgezg ezorh oeivhjk eh veh ezioh geziur vhh ezhezhgzerhgklesheuhezlge Sed mollis diam eu sem bibendum venenatis jfv ezr aezrazeiu aziu azuei fazeiuah aez ziue faz fraziufh auzifh of hazeiufh zaiuzi ufzhaefiu hzfiu azfuzfaziufghaziuef hazfiu hazfuihfuoezi fhzefiuhzaf azfhazefi zif zfuh ziof zifo zhafuhaz ef zfza if zaefzfhazeiuf  azefi zfiu zefh aziuef azieuf ziufh aziefziuaef ziuef zuf f fze fve ger g erzg erzg erz g erzg eg ezrg er gerz gzegez gd sg zegze gf ze g ezgf  ezgzerg ef d g ezr g ezrgzerg ezrg ze g ezr g ezrg e "));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
		for(int j = 0; j < i ; j++)
		{
			messages.add(new MessageTextView("Something"));
		}
	}
	
	/**
	 * Set messages like mm
	 * @param mm (Message_Manager)
	 */
	public Message_Manager(ArrayList <MessageView> mm)
	{
		this.messages = mm;
	}
	
	/**
	 * Singleton method
	 * @return Message_Manager
	 */
	static public Message_Manager getMessageManager()
	{
		if(messageManager == null) messageManager = new Message_Manager(3);
		return messageManager;
	}
	
	public MessageView getMessageView(int i){
		return messages.get(i);
	}
	
	
}

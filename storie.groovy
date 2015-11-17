@Grab(group='org.mobicents.external.freetts', module='freetts', version='1.0')
@Grab(group='org.mobicents.external.freetts', module='en_us', version='1.0')
@Grab(group='org.mobicents.external.freetts', module='cmu_us_kal', version='1.0')
@Grab(group='org.mobicents.external.freetts', module='cmu_time_awb', version='1.0')
@Grab(group='org.mobicents.external.freetts', module='cmulex', version='1.0')
@Grab(group='org.mobicents.external.freetts', module='cmutimelex', version='1.0')

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

def storia = GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    inizio = ['C\'era una volta']
    inizio2 = ['','tanto tempo fa', 'tanto tanto tempo fa', ' tantissimo tempo fa', ]
    inizio3 = ['','in un paese lontano', 'a Marene ']
    nome = [Alice, Luca, Tea, Ivan]
    aggettivo = [ciccione, lecchino]
    verbo = ['voleva ${avverbio} mangiare', 'voleva ${avverbio} leccare']
    avverbio = [sempre, spesso]
    nomeAggettivo = ['${nome}','${nome} ${aggettivo}']
    soggetto = _constant(nomeAggettivo)
    altro =  _constant(nomeAggettivo)
    frase = '${inizio} ${inizio2} ${inizio3} ${soggetto} che ${verbo} ${altro} ma ${altro} non ${verbo} ${soggetto}'
}.output('${frase}')

println storia

Voice voice;
VoiceManager voiceManager = VoiceManager.getInstance();
voiceManager.getVoiceInfo()
//voiceManager.getVoices().each{ println it.name}
voice = voiceManager.getVoice("kevin16");
voice.allocate();
voice.speak(storia);
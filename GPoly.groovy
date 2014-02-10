import groovy.json.JsonSlurper

class GPoly {

    def _vars=[:]
    def _random
    def _settings=[:]

    /**
     * This method accepts a closure which is essentially the DSL. Delegate the 
     * closure methods to
     * the DSL class so the calls can be processed
     */
    static GPoly make(closure) {
        GPoly gpoly = new GPoly()
        // any method called in closure will be delegated to the GPoly class
        closure.delegate = gpoly
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        gpoly
    }
    public GPoly(){
        _random = new Random()
    }
    def randomSeed(int seed){
        _random = new Random(seed)
    }

    def methodMissing(String name, args) {
        if (args&&args.length==1){
          _set name, args[0]
        } else if (args&&args.size==1){
          _set name, args
        }
    }
    def propertyMissing(String name, value) { 
        _set name, value
    }
    def propertyMissing(String name) { 
        if (_vars.containsKey(name)){
            _resolve name
        } else {
            name
        }
    }
    def _set(String name, value) { 
        if (value instanceof File){
            _vars[name] = _parseFile(value)
        } else if (value instanceof URL){
            _vars[name] = _parseFromUrl(value)
        } else if (value instanceof Range ){
            def _list = []
            value.each{
                _list << it
            }
            _vars[name] = _list
        } else {
            _vars[name] = value 
        }
    }
    def _resolve(name){
        def value = _vars[name]
        if (value instanceof List){
            if (value.size()==0){
                return "'${name}:empty!"
            }
            int index=_random.nextInt(value.size())
            if (_remove(name)){
                return value.remove((int)index)
            } else {
                return value[index]
            }
        } 
        return value
    }
    def _remove(name){
        if (_settings&&_settings.containsKey(name)&&_settings[name].containsKey("remove")){
            return _settings[name].remove
        } else if (_settings.containsKey("remove")){
            return _settings.remove
        }
        return true
    }
    def _parseFile(file) { 
        def values = _parseJSONString(file.text)
    }
    def _parseFromUrl(url) { 
        File tempFile = File.createTempFile("tempGPoly",".resource")
        _downloadFile(url, tempFile)
        def values = _parseJSONString(tempFile.text)
        tempFile.delete()
        return values
    }
    def _parseJSONString(text){
        return new JsonSlurper().parseText(text).data
    }
    def _downloadFile(URL remoteUrl, File file) {
       file.withOutputStream { out ->
            remoteUrl.withInputStream { from ->  out << from; }
        }
    }
    def output(text){
        //def engine = new groovy.text.GStringTemplateEngine()
        //def binding = [:]
        //def template = engine.createTemplate(text).make()
        //return template.toString()
        //println {->return text.toString}
        //println '"'+text.toString()+'"'
        GPolyBinding gpolyBinding = new GPolyBinding(this)
        GroovyShell shell = new GroovyShell(gpolyBinding);
        while (text.contains('${')){
            text = shell.evaluate('return "'+text.toString()+'".toString()')
        }
        return text
    }

}  
public class GPolyBinding extends Binding {
        
    GPoly gpoly

    GPolyBinding(GPoly gpoly){
        this.gpoly = gpoly
    }

    public Object  getVariable(String name) {
        return gpoly._resolve(name)
    }
    public void setVariable(String name, Object value) {
        throw new RuntimeException("variable "+name+" is read only");
    }
}
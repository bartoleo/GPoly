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
            _resolve name, _vars[name]
        } else {
            name
        }
    }
    def _set(String name, value) { 
        _vars[name] = value 
    }
    def _resolve(name, value){
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

    def output(text){
        //def engine = new groovy.text.GStringTemplateEngine()
        //def binding = [:]
        //def template = engine.createTemplate(text).make(binding)
        //return template.toString()
        //println {->return text.toString}
        //println '"'+text.toString()+'"'
        //println GroovyShell.evaluate('return "'+text.toString()+'"')
        //println text.toString()
        text
    }

}  
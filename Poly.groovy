class Poly {

    def _vars=[:]
    def _random

    /**
     * This method accepts a closure which is essentially the DSL. Delegate the 
     * closure methods to
     * the DSL class so the calls can be processed
     */
    static Poly make(closure) {
        Poly poly = new Poly()
        // any method called in closure will be delegated to the Poly class
        closure.delegate = poly
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()
        poly
    }
    public Poly(){
        _random = new Random()
    }
    def randomSeed(int seed){
        _random = new Random(seed)
    }

    def methodMissing(String name, args) {
        if (args&&args.length==1){
          _vars[name] = args[0]
        } else if (args&&args.size==1){
            _vars[name] = args          
        }
    }
    def propertyMissing(String name, value) { 
        _vars[name] = value 
    }
    def propertyMissing(String name) { 
        if (_vars[name]){
            _resolve _vars[name]
        } else{
            name
        }
    }
    def _resolve(value){
        if (value instanceof List){
            value = value[_random.nextInt(value.size())]
        } else {
            value
        }
    }

    def output(text){
        println text
    }

}  
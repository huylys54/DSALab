public class Fraction{
    private int numer;
    private int denom;

    public Fraction(){
        this(0, 1);
    }

    public Fraction(int x, int y){
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction f){
        this.numer = f.getNumer();
        this.denom = f.getDenom();
    }

    public int getNumer(){
        return this.numer;
    }

    public int getDenom(){
        return this.denom;
    }

    public void setDenom(int denom){
        this.denom = denom;
    }

    public void setNumer(int numer){
        this.numer = numer;
    }

    private Fraction reuduce(){
        int x = this.numer;
        int y = this.denom;
        while(x != y){
            if(x > y){
                x -= y;
            }else{
                y -= x;
            }
        }
        int newNumer = this.numer / x;
        int newDemon = this.denom / y;

        return new Fraction(newNumer, newDemon);
    }
    @Override
    public boolean equals(Object f){
        if(f instanceof Fraction){
            Fraction fraction = (Fraction) f;
            Fraction reducedFraction1 = this.reuduce();
            Fraction reducedFraction2 = fraction.reuduce();
            return reducedFraction1.getNumer() == reducedFraction2.getNumer() &&
                    reducedFraction1.getDenom() == reducedFraction2.getDenom();
        }
        return false;
    }

    public String toString(){
        return Integer.toString(this.numer) + "/" + Integer.toString(this.denom);
    }
}
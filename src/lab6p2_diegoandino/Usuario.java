
package lab6p2_diegoandino;

public abstract class Usuario {
protected String user;
    protected float pass;
    protected int edad;

    public Usuario() {
    }

    public Usuario(String username, float password, int edad) {
        this.user = username;
        this.pass= password;
        this.edad = edad;
    }

    public Usuario(String username, float password) {
        this.user = username;
        this.pass = password;
    }

    
    public String getUsername() {
        return user;
    }

    public void setUsername(String username) {
        this.user = user;
    }

    public float getPassword() {
        return pass;
    }

    public void setPassword(float password) {
        this.pass = pass;
    }

    

    @Override
    public String toString() {
        return user + " - "+edad;
    }

    public abstract int getEdad();
        

    public abstract void setEdad(int edad) throws Exception;
        

}

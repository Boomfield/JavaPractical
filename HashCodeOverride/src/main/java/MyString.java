public class MyString{
    String name;

    public MyString(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.charAt(0)+name.charAt(1)+name.charAt(2)+name.charAt(3);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

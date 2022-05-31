package pages.helpers;

public enum TypeTitle {
    Topic,
    SoftwareProduct,
    Experience,
    Type,
    Options;

    public String getUIValue () {
        switch (this) {
            case SoftwareProduct: return "Software Product";
            default: return null;
        }

    }

}

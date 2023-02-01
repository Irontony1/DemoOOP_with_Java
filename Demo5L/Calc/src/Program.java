public class Program {
    public static void main(String[] args) {
        Presenter<SumModel> p = new Presenter<>(new SumModel(), new View());
        p.buttonClick();

        Presenter<MulModel> p1 = new Presenter<>(new MulModel(), new View());
        p1.buttonClick();

    }
}
public class Presenter<T extends CalcModel> {
    View view;
    IModel model;
    public Presenter(T m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick() {
        int a = view.getValue("a: ");
        int b = view.getValue("b: ");
        model.setX(a);
        model.setY(b);
        int result = model.result();
        view.print(result, model.getTitle());
    }
}

package competition;

public class TextEditor {

    private StringBuilder content;

    private int index;

    public TextEditor() {
        index = 0;
        content = new StringBuilder();
    }

    public void addText(String text) {
        content.insert(index,text);
        index += text.length();
    }

    public int deleteText(int k) {

        int tmp = 0;
        if (k > index){
            content.delete(0,index);
            tmp = index;
            index = 0;
            return tmp;
        }else {
            content.delete(index-k,index);
            index -= k;
            return k;
        }

    }

    public String cursorLeft(int k) {

        if (index > k){
            index -= k;
        }else {
            index = 0;
        }

        int min = Math.min(10, index);

        return content.substring(index-min,index);
    }

    public String cursorRight(int k) {
        int length = content.length();
        if (length - index > k){
            index += k;
        }else {
            index = length;
        }

        int min = Math.min(10, index);

        return content.substring(index-min,index);
    }
}

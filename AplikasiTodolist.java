public class AplikasiTodolist {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        // testShowTodolist();
        // testAddTodolist();
        // testRemoveTodolist();
        // showTodolist();
        // testInput();
//        testViewAddTodoList();
        testViewRemoveTodoList();

    }

    /*
     * menampilkan todolist
     */
    public static void showTodolist() {
        System.out.println("==xx=TODO LIST=xx==");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }

        }

    }

    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
        showTodolist();

    }

    /*
     * menambah todolist
     */
    public static void addTodolist(String todo) {
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                // model masih ada yang kosong
                break;

            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        // var temp untuk menyimpan array sebelumnya. karna jika melebihi kapasitas
        // array, saat * 2, akan menghapus array sebelumnya
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data arraynya Null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodolist() {
        for (int i = 1; i < 25; i++) {
            addTodolist("contoh Todo ke - " + i);
        }
        // addTodolist("satu");
        showTodolist();
    }

    /*
     * menghapus todolist
     */
    public static boolean removeTodolist(int number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            // model[number - 1] = null;
            // return true;
            // tidak bisa menggunakan logic diatas, karena ketika menghapus salah satu item,
            // tidak menggeser nomor setelahnya jadi berurutan
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;

        }
    }

    public static void testRemoveTodolist() {
        addTodolist("mencuci");
        addTodolist("menyapu");
        addTodolist("menyetrika");
        addTodolist("belajar");

        var result = removeTodolist(7);
        System.out.println(result);

        result = removeTodolist(6);
        System.out.println(result);
        showTodolist();

    }

    public static String input(String info) {
        System.out.println(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * menampilkan view @todo list
     */
    public static void viewShowTodolist() {
        while (true) {
            showTodolist();
            System.out.println("MENU TODO LIST");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }

        }
    }

    public static void testViewShowTodoList(){
        addTodolist("satu");
        addTodolist("dua");
        addTodolist("tiga");
        addTodolist("empat");
        addTodolist("lima");
        viewShowTodolist();
    }

    /**
     * menampilkan view menambahkan todo list
     */
    public static void viewAddTodolist() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = input("Tambahkan Todo (enter x jika batal)");

        if (todo.equals("x")) {
            //batal
        }else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodoList(){

        addTodolist("belajar java");
        addTodolist("praktek java");
        addTodolist("bermain bola ");

        viewAddTodolist();
        showTodolist();

    }

    /**
     * menampilkan view menghapus todo list
     */
    public static void viewRemoveTodolist() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (enter x jika batal)");
        if (number.equals("x")){
            //batal
        }else{
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodolist("belajar java");
        addTodolist("belajar javascript");
        addTodolist("belajar php");
        addTodolist("belajar kotlin");
        showTodolist();

        viewRemoveTodolist();

        showTodolist();
    }

}

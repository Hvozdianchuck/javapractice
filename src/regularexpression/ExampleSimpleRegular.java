package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleSimpleRegular {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("cat");
//        Matcher matcher = pattern.matcher("About cats and dogs");
//        while(matcher.find()){
//            System.out.println(matcher.start()+ " "+ matcher.group()+" ");
//    }
        //special characters - metacharacters
        //[] \ ^$.|&*+()
        System.out.println("".matches(""));
                Pattern pattern = Pattern.compile("1\\+2\\=3");
                //or  Pattern pattern = Pattern.compile("\\Q1+2=3\ \E");
        Matcher matcher = pattern.matcher("1+2+3");
        while(matcher.find()){
            System.out.println(matcher.start()+ " "+ matcher.group()+" ");
          }
        Pattern pattern2 = Pattern.compile("[0-4a-z]");
            Matcher matcher2 = pattern2.matcher("147vnc");
        while(matcher2.find()){
            System.out.println(matcher2.start()+ " "+ matcher2.group()+" ");
        }
        Pattern pattern3 = Pattern.compile("gr[ea]y");
        Matcher matcher3 = pattern2.matcher("grey");
        while(matcher2.find()){
            System.out.println(matcher2.start()+ " "+ matcher2.group()+" ");
        }

        // для []   екранувати треба тільки ]  \ ^-крім чогось(має стояти перед чимось ^x якщо післья x^ то перестає бути спеціальним сисволом) -
        // не буде спеціальним символом ] якщо []x. не буде спеціальним символом [-x] чи [x-]

    // \d -[0-9] \w-[a-zA-Z] \s [ \t] \D [^\d] і так само з іншими
        //.-будь який символ -[^\n] unix - [^\r\n] windows
//        Pattern pattern4 = Pattern.compile("\\d\\d.\\d\\d.\\d");
        Pattern pattern4 = Pattern.compile("\\d\\d[- / .]\\d\\d.\\d");//краще таке використати
        Matcher matcher4 = pattern4.matcher("27/12/18");
        while(matcher4.find()){
            System.out.println(matcher4.start()+ " "+ matcher4.group()+" ");
        }
//        Pattern pattern5 = Pattern.compile("\".*\"");// каже що таких символів може бути багато
        Pattern pattern5 = Pattern.compile("\"[^\"\r\n]*\"");
        Matcher matcher5 = pattern5.matcher("put \"string one \" and \"string two\" ");
        while(matcher5.find()){
            System.out.println(matcher5.start()+ " "+ matcher5.group()+" ");
        }
        // \b- граница слова \bbird\b \B \w \W
        //\b\w+\b
        Pattern pattern6 = Pattern.compile("\\bon\\b");
        Matcher matcher6 = pattern6.matcher("put on");
        while(matcher6.find()){
            System.out.println(matcher6.start()+ " "+ matcher6.group()+" ");
        }
        //anchors  if ^ inside [] - товсьо крім чогось if ^ outside [] початок строки  if $ outside [] кінець  строки *-від нуля до множини символів
        Pattern pattern7 = Pattern.compile("^a");
//        Pattern pattern7 = Pattern.compile("e$");
        Matcher matcher7 = pattern7.matcher("apple");
        while(matcher7.find()){
            System.out.println(matcher7.start()+ " "+ matcher7.group()+" ");
        }
        Pattern pattern8 = Pattern.compile("^\\в+$", Pattern.MULTILINE);
//        Pattern pattern8 = Pattern.compile("^\\Aone\\S", Pattern.MULTILINE);аналогія початку і кінця строки \\A -^ \\Z-$ і ті   не враховують \n але \z  враховується
        Matcher matcher8 = pattern8.matcher("apple");
        while(matcher8.find()){
            System.out.println(matcher8.start()+ " "+ matcher8.group()+" ");
        }
        // |(pipeline) - або то або то
        //?- може бути може не бути
        Pattern pattern9 = Pattern.compile("colou?r");
//        Pattern pattern9 = Pattern.compile("Nov(ember)?");//greedy
        //        Pattern pattern9 = Pattern.compile("Nov(ember)??");//reluctant
        Matcher matcher9= pattern9.matcher("November");
        while(matcher8.find()){
            System.out.println(matcher8.start()+ " "+ matcher8.group()+" ");
        }
        //*- означає що символ перед ним може повторитися від 0 до безкінечності кількість разів  +-означає що символ перед ним може повторитися від 1 до безкінечності кількість разів
        //{2,4} від двох до чотирьох

        //групи () \\1 backreference якщо в  то s1 (?: a) робить щоб не запамятовувалися
        // іменовані групи (?<name>a) \\k<name> ${name}

        // unicode /uі сам юнікод  або //x{і сам юнікод}
        // ?+, *+  +-в таких випадках робить це possesive схоже на greedy але  possesive йде далі знаку кінця строки і забуває співпадіння які були в тому рядку

        //"integers".matches("\\b(?>integer|insert|in)") перевірить чи integer не підходить. не підходить і івсе вийде з групиа якби не було ?> то продовжило би пошук в групі

        // lookaround
        //lookhead
        // posetive-q(?=u) хочем щоб після q йшло u   negative- q(?!u) хочем щоб після q не йшло u
      //  (?=(a)) якщо ми хочемо ссилатися до групи по номеру то треби регулярку в дужки взяти
        //lookbehind
        // posetive-(?<=u)q хочем щоб перед q йшло u   negative- (?<!u)q хочем щоб перед q не йшло u
        // if then else
        // (?ifthen|else) (?if(?=a)then|else) (?if(then|then|then|then)|(else|else|else|else)
    }

    }


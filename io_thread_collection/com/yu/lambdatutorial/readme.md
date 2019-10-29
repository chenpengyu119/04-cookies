函数式编程（英语：functional programming）或称函数程序设计，
又称泛函编程，是一种编程典范，它将计算机运算视为数学上的函数计算，
并且避免使用程序状态以及易变对象。函数编程语言最重要的基础是λ演算（lambda calculus）。
而且λ演算的函数可以接受函数当作输入（引数）和输出（传出值）。

Lambda表达式：
语法特征：
  1. 一个括号内用逗号隔开的参数列表，参数即函数式接口里方法的参数
  2. 一个箭头符号 ： -> 
  3. 方法体。可以是表达式和代码块
 如：parameter -> expression body
 几个重要特征：
     可选的类型声明：你不用去声明参数的类型。编译器可以从参数的值来推断它是什么类型。
     可选的参数周围的括号：你可以不用在括号内声明单个参数。但是对于很多参数的情况，括号是必需的。
     可选的大括号：如果表达式体里面只有一个语句，那么你不必用大括号括起来。
     可选的返回关键字：如果表达式体只有单个表达式用于值的返回，那么编译器会自动完成这一步。若要指示表达式来返回某个值，则需要使用大括号。
 方法引用；
 函数式接口：函数式接口是只包含一个方法的接口。
     Java 8 开始定义了大量的函数式接口来广泛地用于 lambda 表达式。
     java.util.function 包中包含了大量的函数式接口，基本可以满足我们的日常开发需求。
     断言：基于boolean的判断，进行提示警告等。
    
# Вежбе -- Објектно-оријентисано програмирање (М, Н, В, Р, Л) @ Математички факултет

[ООП](../README.md) [Часови уживо 2019/2020](./casovi-uzivo/README.md) [Часови уживо 2020/2021](./casovi-uzivo/snimci-2020-2021.md)

---

## Садржај курса

1. [Увод у Јаву](./prezentacije/01.uvod.pdf){:target="_blank"}
	
    1. 	Примитивни типови података у Јави
    2.	Учитаванје са стандардног улаза (класа `Scanner`)
    3. 	`for` петља, `while` петља, рекурзија
    4. 	Библиотека математичких функција (класа `Math`)
    5.  [Пројекат са свим кодовима](./primeri-java/01.uvod.zip)
    7.  [Домаћи](./domaci/01.txt)


2. Низови, матрице и ниске
   1.  [Низови и матрице примитивних типова](./prezentacije/02.nizovi.matrice.pdf){:target="_blank"}
   2.  Класа `Arrays`
   3.  Класе `String` и `StringBuilder`
   4.  [Пројекат са свим кодовима](./primeri-java/02.nizovi.matrice.stringovi.zip)
   5.  Домаћи: [низови](./domaci/02_nizovi.txt), [ниске](./domaci/02_stringovi.pdf)

3. [Објектно-оријентисано програмирање](./prezentacije/03.oop.pdf){:target="_blank"}
   1. Класа `Student` : поља, конструктор, `get` и `set` методе, метод `toString`, `this`

   2. Побољшање класе `Student`: увођење валидација, приватни методи

   3. Класа `Tacka`: подразумевани и стандардни конструктор, поређење објеката
   
   4. [Пројекат са свим кодовима](./primeri-java/03.oop.zip)

   5. [Домаћи](./domaci/03_oop.pdf){:target="_blank"}

<!---
4. [Наслеђивање](./prezentacije/04.klase.nasledjivanje.pdf){:target="_blank"}

   1. Допуна класе `Tacka`: конструктор копије, статичке променљиве и методе

   2. Наслеђивање кроз пример хијерарјије облика:
      * Енкапсулација
      * Спецификатори видљивости 
      * Конструктори наткласе и променљива `super`
      * Превазилажење метода наткласе (`toString` из класе `Object`)

   3. [Пројекат са свим кодовима](./primeri-java/04.nasledjivanje.zip)

   4. [Домаћи](./domaci/04_nasledjivanje.pdf){:target="_blank"} 


5. Апстрактне класе, полиморфизам
   1. Проширивање хијерархије облика: апстрактни методи за рачунање површине и обима, оператор `instanceof` и метод `getClass()`.

   2. Хијерархија класа за описивање израза

   3. Допуна хијерархије израза: апстрактни метод за прављење копија објеката

   4. [Пројекат са свим кодовима](./primeri-java/05.apstraktne.polimorfizam.zip){:target="_blank"} 

6. Интерфејси
   1. Имплементација интерфејса `SrpskiJezik` и `EngleskiJezik`.
   
   2.  Проширивање хијерархије облика: класа `Duz`, интерфејси `Obim` и `Povrsina`.
   
   3. Имплементација интерфејса `Stek`, енумерациони тип `Operacija`.
   
   4. Имплементација интерфејса `Red`. 
   
   5. Клонирање: имплементација интерфејса `Clonable`, плитко и дубоко клонирање. 
   
   6. [Пројекат са свим кодовима](./primeri-java/06.interfejsi.zip){:target="_blank"} 
   7. 
7. Изузеци
   
   1. Хватање изузетка - `try-catch`  блок
   
   2. Вишеструки изузеци
   
   3. Затварање ресурса - `finally`  блок
   
   4. Аутоматско затварање ресурса - `try-with-resources`  блок
   
   5. [Пројекат са свим кодовима](./primeri-java/07.izuzeci.kloniranje.zip){:target="_blank"} 

8. Генеричке класе

   1. Генеричке функције
   
   2. Генеричка класа `Kutija`
   
   3. Генеричка класа `OpcionaVrednost`, `wildcard`
   
   4. Генеричка класа `UredjeniPar` - више типских параметара
   
   5. Генерички интерфејс `GenerickiStek` 
   
   6. [Пројекат са свим кодовима](./primeri-java/08.genericke.klase.zip){:target="_blank"}  


9.  Генеричке колекције

    1.  `LinkendList<T>`

    2.  `ArrayList<T>`

    3.  `TreeSet<T>`

    4.  `TreeMap<T>` 

    5. `HashMap<T>` 
   
    6.  [Пројекат са свим кодовима](./primeri-java/09.kolekcije.zip){:target="_blank"}  

10. Поређење објеката
   
    1.  Интерфејс `Comparable<T>`

    2.  Интерфејс `Comparator<T>`
    
	1.  Поређење објеката хијерархије облика  
   
    1.  [Пројекат са свим кодовима](./primeri-java/10.poredjenje.objekata.zip){:target="_blank"} 


11. [Датотеке](./primeri-java/11.datoteke/src/datoteke/CitanjePisanje.java){:target="_blank"}  

12. Графичко корисничко окружење

    1.  Библиотека `JavaFx`

    2.  Контејнер елементи - `HBox` и `VBox`
    
	2.  Елементи за обележавање - `Label`
    
	3.  Дугмићи и акције - `Button`	
    
	4.  Текстуална поља и области - `TextField` и `TextArea`
    
	5.  Радио дугмићи - `RadioButton`
    
	6.  Платно за цртање - `Canvas`
    
	7.  [Пројекат са свим кодовима](./primeri-java/12.javafx.zip){:target="_blank"} 


13. [Токови](./primeri-java/13.tokovi.zip){:target="_blank"}
-->
---

[ООП](../README.md)  [Часови уживо 2019/2020](./casovi-uzivo/README.md) [Часови уживо 2020/2021](./casovi-uzivo/snimci-2020-2021.md)

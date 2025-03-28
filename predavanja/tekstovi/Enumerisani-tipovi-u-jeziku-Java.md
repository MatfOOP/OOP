# Објектно орјентисано

# програмирање

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs


# Енумерисани и генерички

# типови

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 3 / 35
```
- Понекад променљива служи за чување вредности из ограниченог

##### скупа. На пример, можда се продаје одећа у четири величине:

##### small, medium, large и extra large.

- Наравно, ове величине се могу кодирати целим бројевима 1, 2, 3,

##### 4 или знацима S, M, L, X. Али такав приступ је склон грешкама.

##### Може се догодити да променљива добије погрешну вредност

##### (попут 0 или m).

- У Јави је могуће дефинисати сопствени енумерисани тип. Такав

##### тип има коначан број именованих вредности.

- На пример, за претходно описану ситуацију уводи се

##### енумерисани тип:

```
enum Velicina {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
```
## Енумерисани тип


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 4 / 35
```
- Енумерисани тип се заправо понаша као класа.
- Класа из претходног примера садржи тачно четири податка тј.

##### тачно четири примерка -није могуће конструисати нове објекте.

- Према томе, нема потребе користити метод equals()за поређење

##### вредности енумерисаног типа, већ се подаци тог типа пореде

##### коришћењем оператора ==.

- Могуће је декларисати променљиву енумерисаног типа.

##### На пример.

```
Velicina v = Velicina.MEDIUM;
```
- Променљива типа Velicinaможе чувати само једну од вредности

##### излистаних у декларацији овог типа или специјалну вредност

##### null.

## Енумерисани тип (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 5 / 35
```
- Могуће је, по потреби, додати конструкторе, методе и поља типу

##### енумерације. Наравно, конструктори се позивају само приликом

##### конструисања константи енумерације. Следи пример.

```
enum Velicina {
SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
```
```
private String skracenica;
```
```
private Velicina(String skracenica) {
this.skracenica = skracenica;
}
```
```
public String getSkracenica() {
return skracenica;
}
}
```
## Енумерисани тип (3)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 6 / 35
```
- Сви типови енумерације су поткласе класе Enum. Они наслеђују

##### известан број метода од те класе.

- Најкориснији међу њима је метод toString(), који враћа име

##### константе енумерације.

- Тако, на пример, Velicina.SMALL.toString()враћа стринг „SMALL“.
- Супротан ефекат има статички метод valueOf().

##### На пример наредба,

```
Velicina v = (Velicina) Enum.valueOf(Velicina.class, "SMALL");
```
##### поставља v на Velicina.SMALL.

## Енумерисани тип (4)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 7 / 35
```
- Сваки тип енумерације поседује статички метод values() који

##### враћа низ вредности енумерације.

- Тако, на пример, наредба

```
Velicina[] vrednosti = Velicina.values();
```
##### враћа низ са елементима:

##### Velicina.SMALL, Velicina.MEDIUM, Velicina.LARGE и Velicina.EXTRA_LARGE.

- Метод ordinal() враћа позицију константе енумерације у enum

##### декларацији, при чему бројање почиње од 0.

- Тако, на пример, Velicina.MEDIUM.ordinal() враћа 1.

## Енумерисани тип (5)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 8 / 35
```
- Енумерације се могу користити код вишеструког гранања

##### помоћу наредбе switch:

```
Velicina v =.. .;
switch (v) {
case SMALL: // nema potrebe koristiti Velicina.SMALL
```
...
break;
...
}
- У caseклаузама не наводи се тип енумерације, већ само име

##### константе.

## Енумерисани тип (6)


## Захвалница

### Велики део материјала који је укључен у ову презентацију је

### преузет из презентације коју је раније (у време када је он

### држао курс Објектно орјентисано програмирање) направио

### проф. др Душан Тошић.

### Хвала проф. Тошићу што се сагласио са укључивањем тог

### материјала у садашњу презентацији, као и на помоћи коју ми

### је пружио током конципцирања и реализације курса.

### Надаље, један део материјала је преузет од колегинице

### Марије Милановић.

### Хвала Марији Милановић на помоћи у реализацији ове

### презентације.



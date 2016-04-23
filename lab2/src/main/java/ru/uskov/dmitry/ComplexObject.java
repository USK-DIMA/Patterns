package ru.uskov.dmitry;


/**
 * Простейший шаблон реализации паттерна Builder
 */
public class ComplexObject {

    /**
    Поля класса
     */
    private String filed1;

    private String filed2;

    private String filed3;

    private String filed4;

    //......


    /**
     * Конструктор будет доступен только билдеру.
     */
    private ComplexObject(String filed1, String filed2, String filed3, String filed4) {
        this.filed1 = filed1;
        this.filed2 = filed2;
        this.filed3 = filed3;
        this.filed4 = filed4;
    }

    /**
     * Методы класса
     */

    //......


    public static class Builder{
        /**
         * Все необходимая информация для создания сложного оъекта.
         * т.к. у нас примитивный пример, поля в билдере совпадают с полями в классе, объект которого будем создавать.
         */
        private String field1;

        private String field2;

        private String field3;

        private String field4;

        /**
         * Ниже в методы небходимо передавать информацию, необходимую для создания объекта (можно вызывать не все методы.)
         * @return ссылка на этот же Builder (см пример.)
         */
        public Builder field1(String field1) {
            this.field1 = field1;
            return this;
        }

        public Builder field2(String field2) {
            this.field2 = field2;
            return this;
        }

        public Builder field3(String field3) {
            this.field3 = field3;
            return this;
        }

        public Builder field4(String field4) {
            this.field4 = field4;
            return this;
        }

        /**
         * В методое содержится логика создания сложного объекта на основании полученных данных.
         * Как мы можем заметить, можно вызывать НЕ все методы buildXXXX(...), т.е. в зависимости от того, какие методы мы вызовем и что туда передадим, при вызове метода build() будут конфигруроваться разные целевые объектыобъекты.
         * Но, существует такая проблема, что пользователь может передать в builder два противоречивых параметра, и объект с такими параметрами создать будет невозможно.
         * Такую ситуацию можно как раз обрабоать в методе build().
         * Если же не использовать builder, а работать только с конструктарами, это вызовет обильное кол-во конструкторов, части кода в которых будут повторяться.
         * Поэтому конструкторов целевого класса не много, они доступны только билдеру и валидность передаваемых данных в эти конструкторы определяется самим билдером.
         * Тем самым получаем гибкий механизм создания слоного объекта удобным способом.
         * @return
         */
        public ComplexObject build(){
            //TODO логика создания сложного объекта на основании полученных данных.
            return new ComplexObject(field1, field2, field3, field4);
        }
    }
}

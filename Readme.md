# Eager vs Lazy Filters
###
Eager istekli bir algoritmadır hemen yürütülür ve bir sonuç döndürür. Lazy tembel bir algoritmadır, yürütülmesi gerekene kadar hesaplamayı erteler ve ardından bir sonuç üretir.Eager ve Lazy algoritmaların hem artıları hem de eksileri vardır. Eager algoritmaları anlamak ve hata ayıklamak daha kolaydır.

## Eager 

````
class Someclass
{
    private final List<String> strings = new ArrayList<>();

    public List<String> getStrings()
    {
        return this.strings;
    }
}
````
##### Eager durumunda, bir SomeClass örneği oluşturulduğunda, liste adlı dizeler hemen başlatılır. Gerekli olup olmadığı sorgunlanmaz.

## Lazy

````
class Someclass
{
    private List<String> strings;

    public List<String> getStrings()
    {
        if (this.strings == null)
        {
            this.strings = new ArrayList<>();
        }
        return this.strings;
    }
}
````

#####  Lazy durumunda, liste adlı dizeler yalnızca getStrings yöntemi çağrıldığında başlatılır. Gerekli hesaplama, yöntem çağrılana kadar ertelenir. Yöntem hiç çağrılmazsa, ekstra hesaplamaya  gerek yoktur.


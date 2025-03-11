---

# **TP : Inversion de Contrôle et Injection des Dépendances avec Spring**

## 📌 **Objectif du TP**
L'objectif de ce TP est d'implémenter une application respectant le principe **"Ouvert à l’extension, fermé à la modification"** en appliquant l'**Inversion de Contrôle (IoC)** et l'**Injection de Dépendances (DI)**.

Nous allons explorer différentes manières de gérer les dépendances :  
✅ **Couplage faible** : dépendre d'interfaces et non de classes concrètes  
✅ **Injection de dépendances** par différentes méthodes :
- Instanciation statique (via setters)
- Instanciation dynamique (via un fichier de configuration)
- Injection avec **Spring** (via `config.xml`)
- Injection avec **Spring et annotations**

Chaque solution est implémentée dans une branche Git distincte.

---

## 📂 **Structure du projet**
```
📦 MonProjet
 ┣ 📂 src/main/java/org/example
 ┃ ┣ 📂 dao       # Couche DAO  
 ┃ ┣ 📂 metier    # Couche Métier  
 ┃ ┣ 📂 presentation # Main  
 ┣ 📂 src/main/resources  
 ┃ ┣ 📄 config.xml  # Configuration Spring (XML)  
 ┣ 📂 branches  
 ┃ ┣ 🔹 feature/static-injection  # Injection par setters  
 ┃ ┣ 🔹 feature/dynamic-injection # Injection via un fichier de config  
 ┃ ┣ 🔹 feature/spring-xml  # Injection avec Spring XML  
 ┃ ┣ 🔹 feature/spring-annotations  # Injection avec annotations Spring  
 ┣ 📄 pom.xml  # Dépendances Maven  
 ┣ 📄 README.md  # Documentation  
```

---

## 🚀 **Méthodes d'Injection Implémentées**

### 🟢 1. **Injection statique (via Setters)**
📌 Implémentée dans la branche **`static-injection`**  
👉 Pour injecter un objet dans la variable dao d’une classe qui implémente l’interface IDao

```java
public class MetierImpl {
    private DaoImpl dao;

    public void setDao(DaoImpl dao) {
        this.dao = dao;
    }
}
```

👎 **Limites** : Code rigide, nécessite une modification directe à chaque changement de dépendance.

---

### 🔵 2. **Injection dynamique (via un fichier config.txt)**
📌 Implémentée dans la branche **`dynamic-injection`**  
👉 Ici, les dépendances sont configurées dynamiquement en les lisant depuis un fichier externe (`config.txt`).

📄 **Exemple de `config.txt` :**
```
org.example.dao.DaoImpl
org.example.metier.MetierImpl

```

👎 **Limites** : Toujours manuel, mais plus flexible que l’injection statique.

---

### 🟠 3. **Injection avec Spring (via config.xml)**
📌 Implémentée dans la branche **`spring-xml`**  
👉 Ici, nous utilisons **Spring et un fichier de configuration XML** (`config.xml`) pour déclarer et injecter les dépendances.

📄 **Exemple de `config.xml`**
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="d" class="org.example.dao.DaoImpl"></bean>
    
    <bean id="metier" class="org.example.metier.MetierImpl">
        <property name="dao" ref="d"/>
    </bean>

</beans>
```

✅ **Avantages** : Plus flexible, permet de changer les dépendances sans modifier le code.

---

### 🟣 4. **Injection avec Spring et Annotations**
📌 Implémentée dans la branche **`spring-annotations`**  
👉 Ici, on utilise **les annotations Spring (@Autowired, @Component, etc.)** pour gérer automatiquement les dépendances.

📄 **Exemple d'implémentation :**
```java
//class DaoImpl
@Component("d")
public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("Version base de données");
        double temp = 23;
        return temp;
    }
}


//class MetierImpl
@Component("metier")
public class MetierImpl implements IMetier{
    // Implémentation IMetier

public MetierImpl(@Qualifier("d") IDao dao) {
    this.dao = dao;
}
}

//class PresentationSpringAnnontation

public class PresentationSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.example");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("Resultats : " + metier.calcul());
    }
}

```

✅ **Avantages** : Plus simple, moins de configuration manuelle, meilleure maintenabilité.

---

## 📖 **Conclusion**
Ce TP montre comment gérer l’inversion de contrôle et l’injection de dépendances pour créer un système flexible et évolutif.  
Spring permet d'automatiser cette gestion et facilite la maintenance du code.

---


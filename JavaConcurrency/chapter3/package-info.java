/**
 * 第3章  Java内存模型
 * 3.1 Java内存模型的基础
 * 1. 并发编程模型的两个关键问题
 * 1）在并发编程中，需要处理两个关键问题：线程之间如何通信及线程之间如何同步。
 * 2）线程之间的通信机制有两种：共享内存和消息传递。
 * 在共享内存的并发模型中，线程之间共享程序的公共状态，通过写-读内存中的公共状态进行隐式通信。
 * 在消息传递的并发模型中，线程之间没有公共状态，线程之间必须通过发送消息来显式进行通信。
 * 3）同步是程序中用于控制不同线程间操作发生相对顺序的机制。
 * 在共享内存中，同步是显示进行的。程序员必须显示指定某个方法或某段代码需要在线程之间互斥执行。
 * 在消息传递中，由于消息的发送必须在消息的接收之前，因此同步是隐式进行的。
 * 4）Java的并发采用的是共享内存模型，Java线程之间的通信总是隐式执行，整个通信对程序员完全透明。
 * 2. Java内存模型的抽象结构
 * 1）在Java中，所有实例域、静态域和数组元素都存储在堆内存中，堆内存在线程之间共享。局部变量、方法定义
 * 参数和异常处理器参数不会再线程之间共享，它们不会有内存可见性问题，也不会受内存模型的影响。
 * 2）Java线程之间的通信由Java内存模型控制，JMM决定一个线程对共享变量的写入何时对另外一个线程可见。
 * 3）JMM通过控制主内存与每个线程的本地内存之间的交互，来为Java程序员提供内存可见性保证。
 * 3. 从源代码到指令序列的重排序
 * 1）在执行程序时，为了提高性能，编译器和处理器常常会对指令进行重排序。有3种类型：
 * 1）编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。
 * 2）指令级并行的重排序。采用指令级并行技术来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
 * 3）内存系统的重排序。由于处理器使用缓存和读/写缓存区，这使得加载和存储操作看上去可能是在乱序执行。
 * 2）这些重排序可能会导致多线程程序出现内存可见性问题。
 * 4. 并发编程模型的分类
 * 1）现代的处理器使用写缓冲区保存临时向内存写入的数据。每个处理器上的写缓冲区，仅仅对它所在的处理器可见。
 * 这个特性会对内存操作的执行顺序产生重要的影响：处理器对内存的读/写操作的执行顺序，不一定与内存实际发生的读/写顺序一致。
 * 2）为了保证内存可见性，Java编译器在生成指令序列的适当位置会插入内存屏障指令来禁止特定类型的处理器顺序。
 * 5. happens-before简介
 * 1）在JVM中，如果一个操作执行的结果需要对另外一个操作可见，那么这两个操作之间必须要存在happens-before关系。这里的操作
 * 可以是在一个线程内，也可以是在不同线程之间。
 * 2）与程序员密切相关的happens-before规则如下：
 * 1）程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后序操作。
 * 2）监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁。
 * 3）volatile变量规则：对一个volatile域的写，happens-before于任意后序对这个volatile域的读写。
 * 4）传递性：如果A happens-before B, 且 B happens-before C, 那么 A happens-before C。
 * 3）注意：两个操作之间具有happens-before关系，并不意味着前一个操作必须要在后一个操作之前执行！
 * happens-before仅仅要求前一个操作（执行的结果）对后一个操作可见，且前一个操作按顺序排在第二个操作之前
 * （the first is visible to and ordered before the second）。
 * <p>
 * 3.2 重排序：是指编译器和处理器为了优化程序性能而对指令序列进行重新排序的一种手段。
 * 1. 数据依赖性：如果两个操作访问同一个变量，且这两个操作中有一个为写操作，此时这两个操作之间就存在数据依赖性。包括写后读、写后写、读后写。
 * 1）编译器和处理器可能会对操作进行重排序。编译器和处理器在重排序时，会遵守数据依赖性，编译器和处理器不会改变存在数据依赖关系的两个操作的执行顺序。
 * 2）这里所说的数据依赖性仅针对单个处理器中执行的指令序列和单个线程中执行的操作，不同处理器之间和不同线程之间的数据依赖性不被编译器和处理器考虑。
 * 2. as-if-serial语义
 * 1）是指不管怎么重排序（编译器和处理器为了提高并行度），（单线程）程序的执行结果不能被改变。编译器、runtime和处理器都必须遵守as-if-serial语义。
 * 2）为了遵守as-if-serial语义，编译器和处理器不会对存在数据依赖关系的操作做重排序，因为这种重排序会改变执行结果。
 * 3. 程序顺序规则
 * 4. 重排序对多线程的影响
 * 1）在单线程程序中，对存在控制依赖的操作重排序，不会改变执行结果（这也是as-if-serial语义允许对存在控制依赖的操作做重排序的原因）；
 * 但在多线程程序中，对存在控制依赖的操作重排序，可能会改变程序的执行结果。
 * <p>
 * 3.3 顺序一致性
 * 1. 数据竞争与顺序一致性
 * 1）当程序未正确同步时，就可能会存在数据竞争。Java内存模型规范对数据竞争的定义如下：
 * 在一个线程中写一个变量，在另一个线程读同一个变量，而且写和读没有通过同步来排序。
 * 2）如果程序是正确同步的，程序的执行将具有顺序一致性（Sequentially Consistent）：即程序的执行结果与该程序在顺序一致性内存模型中的执行结果相同。
 * 2. 顺序一致性内存模型
 * 1）两大特性：a.一个线程中的所有操作必须按照程序的顺序来执行。   b.（不管程序是否同步）所有线程都只能看到一个单一的操作执行顺序。
 * 在顺序一致性内存模型中，每个操作都必须原子执行且立刻对所有线程可见。
 * 2）未同步的程序在顺序一致性模型中虽然整体执行顺序是无序的，但所有线程都只能看到一个一致的整体执行顺序。因为顺序一致性内存模型中的每个操作
 * 必须立即对任意线程可见。但是，在JMM中就没有这个保证。未同步程序在JMM中不但整体的执行顺序是无序的，而且所有线程看到的操作执行顺序也可能不一致。
 * 3. 未同步程序的执行特性
 * 1）JMM不保证未同步程序的执行结果与该程序在顺序一致性模型中的执行结果一致。未同步程序在JMM中的执行时，整体上是无序的，其执行结果无法预知。未同步程序
 * 在两个模型中的执行特性有如下一个差异：
 * a）顺序一致性模型保证单线程内的操作会按程序的顺序执行，而JMM不保证单线程内的操作会按程序的顺序执行。
 * b）顺序一致性模型保证所有线程只能看到一致的操作执行顺序，而JMM不保证所有线程能看到一致的操作执行顺序。
 * c）JMM不保证对64位的long型和double型变量的写操作具有原子性，而顺序一致性模型保证对所有的内存读/写操作具有原子性。
 * <p>
 * 3.4 volatile的内存语义
 * 1. volatile的特性
 * 1）理解volatile特性的一个好方法是把对volatile变量的单个读/写，看成是使用同一个锁对这些单个读/写操作做了同步。
 * 2）volatile变量自身具有下列特性：
 * a）可见性。对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
 * b）原子性。对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性。
 * 2. volatile 写-读建立的happens-before关系
 * 1）从内存语义的角度来说，volatile的写-读与锁的释放-获取具有相同的内存效果：volatile写和锁的释放有相同的内存语义；volatile读与锁的获取具有相同的内存语义。
 * 3. volatile 写-读的内存语义
 * 1）volatile写的内存语义是：当写一个volatile变量时，JMM会把该线程对应的本地内存中的共享变量值刷新到主内存。
 * 2）volatile读的内存语义是：当读一个volatile变量时，JMM会把该线程对应的本地内存设置为无效。线程接下来将从主内存中读取共享变量。
 * 3）下面对volatile写和volatile读的内存语义做个总结。
 * a）线程A写一个volatile变量，实质上是线程A向接下来将要读这个volatile变量的某个线程发出了（其对共享变量所做修改的）消息。
 * b）线程B读一个volatile变量，实质上是线程B接收了之前某个线程发出的（在写这个volatile变量之前对共享变量所做的修改的）消息。
 * c）线程A写一个volatile变量，随后线程B读这个volatile变量，这个过程实质上是线程A通过主内存向线程B发送消息。
 * 4. volatile内存语义的实现
 * 1）JMM针对编译器制定了volatile的重排序规则：
 * a）当第二个操作是volatile写时，不管第一个操作是什么，都不能重排序。这个规则确保volatile写之前的操作不会被编译器重新排序到volatile写之后。
 * b）当第一个操作是volatile读时，不管第二个操作是什么，都不能重排序。这个规则确保volatile读之后的操作不会被编译器重新排序到volatile读之前。
 * c）当第一个操作是volatile写，第二个操作是volatile读时，不能重排序。
 * 2）为了实现volatile的内存语义，编译器在生成字节码时，会在指令序列中插入“内存屏障”来禁止特定类型的处理器重排序。下面是基于保守策略的JMM内存屏障插入策略。
 * a）在每个volatile写操作的前面插入一个StoreStore屏障。
 * b）在每个volatile写操作的后面插入一个StoreLoad屏障。
 * c）在每个volatile读操作的后面插入一个LoadLoad屏障。
 * d）在每个volatile读操作的后面插入一个LoadStore屏障。
 * 3）上面的内存插入策略非常保守，但它可以保证在任意处理器平台，任意的程序中都能得到正确的volatile内存语义。
 * 4）X86处理器仅会对写-读操作做重排序。X86不会对读-读、读-写和写-写操作做重排序。
 * <p>
 * 3.5 锁的内存语义
 * 1. 锁的释放和获取的内存语义
 * 1）锁释放与volatile写有相同的内存语义；锁获取与volatile读有相同的内存语义。
 * 2）下面对锁释放和锁获取的内存语义进行总结：
 * a）线程A释放一个锁，实质上是线程A向接下来将要获取这个锁的某个线程发出了（线程A对共享变量所做修改的）消息。
 * b）线程B获取一个锁，实质上是线程B接收了之前某个线程发出的（在释放这个锁之前对共享变量所做修改的）消息。
 * a）线程A释放锁，随后线程B获取这个锁，这个过程实质上是线程A通过主内存向线程B发送消息。
 * 2. 锁内存语义的实现
 * 1）借助ReentrantLock的源代码，来分析锁内存语义的具体实现机制。
 * 2）ReentrantLock分为公平锁和非公平锁。
 * a）公平锁和非公平锁释放时，最后都要写一个volatile变量state。
 * b）公平锁获取时，首先会去读volatile变量。
 * c）非公平锁获取时，首先会用CAS更新volatile变量，这个操作同时具有volatile读和volatile写的内存语义。
 * 3. concurrent包的实现
 * 1）由于Java的CAS同时具有volatile读和volatile写的内存语义，因此Java线程之间的通信现在有了下面4种方式。
 * a）A线程写volatile变量，随后B线程读这个volatile变量。
 * b）A线程写volatile变量，随后B线程用CAS更新这个volatile变量。
 * c）A线程用CAS更新一个volatile变量，随后B线程用CAS更新这个volatile变量。
 * d）A线程用CAS更新一个volatile变量，随后B线程读这个volatile变量。
 * <p>
 *     3.6 final域的内存语义
 *     1. final域的重排序规则
 *     1）在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
 *     2）初次读一个包含final域的对象的引用，与随后初次读这个final域，这两个操作之间不能重排序。
 *     2. 写final域的重排序规则
 *     1）JMM禁止编译器把final域的写重排序到构造函数之外。
 *     2）编译器会在final域的写之后，构造函数return之前，插入一个StoreStore屏障。这个屏障禁止处理器把final域的写重排序到构造函数之外。
 *     3. 读final域的重排序规则
 *     1）在读一个对象的final域之前，一定会先读包含这个final域的对象的引用。
 *     4. final域为引用类型
 *     1）对于final域为引用类型，写final域的重排序规则对编译器和处理器增加了如下约束：在构造函数内对一个final引用的对象的成员域的写入，
 *     与随后在构造函数外把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
 *     5. 为什么final引用不能从构造函数内“溢出”
 *     1）需要一个保证：在构造函数内部，不能让这个被构造对象的引用为其他线程所见，也就是对象引用不能在构造函数中“逸出”
 *     2）在构造函数返回前，被构造对象的引用不能为其他线程可见，因为此时的final域可能还没有被初始化。在构造函数返回后，
 *          任意线程都将保证能看到final域正确初始化之后的值。
 *     6. final语义在处理器中的实现：在X86处理器中，final域的读/写不会插入任何内存屏障！
 *
 *
 *     3.7 happens-before
 *     1. JMM的设计
 *     1）从JMM设计者的角度，在设计JMM时，需要考虑两个关键因素。
 *      a）程序员对内存模型的使用。程序员希望内存模型易于理解、易于编程。程序员希望基于一个强内存模型来编写代码。
 *      b）编译器和处理器对内存模型的实现。编译器和处理器希望内存模型对它们的束缚越少越好，这样它们就可以做尽可能多的优化来提高性能。
 *      编译器和处理器希望实现一个弱内存模型。
 *     2）JMM把happens-before要求禁止的重排序分为下面两类，并采用不同的策略：
 *      a）会改变程序执行结果的重排序，JMM要求编译器和处理器必须禁止这种重排序。
 *      b）不会改变程序执行结果的重排序，JMM对编译器和处理器不做要求（JMM允许这种重排序）。
 *     3）JMM向程序员提供的happens-before规则能满足程序员的需求。JMM的happens-before不但简单易懂，而且也向程序员提供了足够强的内存可见性保证。
 *     4）JMM对编译器和处理器的束缚已经尽可能少。只要不改变程序的执行结果（指的是单线程程序和正确同步的多线程程序），编译器和处理器怎么优化都行。
 *     2. happens-before的定义
 *     1）定义如下：
 *      a）如果一个操作happens-before另外一个操作，那么第一个操作的执行结果将对第二个操作可见，而且第一个操作的执行顺序排在第二个操作之前。
 *      b）两个操作之间存在happens-before关系，并不意味着Java平台的具体实现必须要按照happens-before关系指定的顺序来执行。如果重排序之后的
 *      执行结果，与按happens-before关系来执行的结果一致，那么这种重排序并不非法。
 *     2）happens-before关系本质上和as-if-serial语义是一回事
 *      a）as-if-serial语义保证单线程内程序的执行结果不被改变，happens-before关系保证正确同步的多线程程序的执行结果不被改变。
 *      b）as-if-serial语义给编写单线程程序的程序员创造了一个幻境：单线程程序是按程序的顺序来执行的。happens-before关系给编写正确同步的
 *      多线程程序的程序员创造了一个幻境：正确同步的多线程程序是按happens-before指定的顺序来执行的。
 *     3. happens-before规则
 *     1）程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后序操作。
 *     2）监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁。
 *     3）volatile变量规则：对一个volatile域的写，happens-before于任意后序对这个volatile域的读写。
 *     4）传递性：如果A happens-before B, 且 B happens-before C, 那么 A happens-before C。
 *     5）start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的ThreadB.start()操作happens-before于线程B中的任意操作。
 *     6）join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作happens-before与线程A从ThreadB.join()操作成功返回。
 *
 *
 *     3.8 双重检查锁定与延迟初始化
 *     1. 双重检查锁定的由来
 *     1）在Java程序中，有时候可能需要推迟一下高开销的对象初始化操作，并且只有在使用这些对象时才进行初始化。此时，程序员可能会采用延迟初始化
 *     2）两种方法来实现线程安全的延迟初始化：不允许重排序；允许重排序，但不允许其他线程看到这个重排序。
 *     2. 基于volatile的解决方案：通过禁止重排序来保证线程安全的延迟初始化
 *     3. 基于类初始化的解决方案。
 *     1）通过对比基于volatile的双重检查锁定的方案和基于类初始化的方案，我们发现基于类初始化的方案的实现代码更简洁。
 *     2）但基于volatile的双重检查锁定的方案有一个额外的优势：除了可以对静态字段实现延迟初始化外，还可以对实例字段实现延迟初始化。
 *     3）字段延迟初始化降低了初始化类或创建实例的开销，但增加了访问被延迟初始化的字段的开销。
 *     4）如果确定需要对实例字段使用线程安全的延迟初始化，请使用基于volatile的延迟初始化方案
 *     5）如果确定需要对静态字段使用线程安全的延迟初始化，请使用基于类初始化的方案。
 *
 *
 *     3.9 Java内存模型综述
 *     1. 处理器的内存模型
 *     2. 各种内存模型之间的关系
 *     1）JMM是一个语言级的内存模型，处理器内存模型是硬件级的内存模型，顺序一致性内存模型是一个理论参考模型。
 *     2）三种内存模型的强弱对比：4种处理器内存模型比常用的3种语言内存模型要弱，处理器内容模型和语言内存模型都比顺序一致性模型要弱。
 *     3. JMM的内存可见性保证
 *     1）单线程程序。单线程程序不会出现内存可见性问题。编译器、runtime和处理器会共同确保单线程程序的执行结果与该程序在顺序一致性模型中
 *     的执行结果相同。
 *     2）正确同步的多线程程序。正确同步的多线程程序的执行将具有顺序一致性（程序的执行结果与该程序在顺序一致性内存模型中的结果相同）。这是
 *     JMM关注的重点，JMM通过限制编译器和处理器的重排序来为程序员提供内存可见性保证。
 *     3）未同步/未正确同步的多线程程序。JMM为它们提供了最小安全性保障：线程执行时读取到的值，要么是之前某个线程写入的值，要么是默认值（0、null、false）
 *     4. JSR-133对旧内存模型的修补
 *     1）JSR-133对JDK5之前的旧内存模型的修补主要有两个。
 *      a）增强volatile的内存语义。旧内存模型允许volatile变量与普通变量重排序。JSR-133严格限制volatile变量与普通变量的重排序。
 *      b）增强final的内存语义。在旧内存模型中，多次读取同一个final变量的值可能会不相同。JSR-133为final增加了两个重排序规则。
 * /
 * /**
 *
 * @author 郑元浩
 */
package chapter3;
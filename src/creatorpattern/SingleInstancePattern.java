package creatorpattern;

/**
 * 这里面包含了6中单利模式的写法
 */
public class SingleInstancePattern {

    static void run() {
        System.out.println("run.....");
    }

    public static void main(String[] args) {

    }
}

class StarvingPattern {
    /**
     * 饿汉模式
     * 优点：
     * 1. 类加载的时候完成初始化，节省了调用时间
     * 2. 线程安全的
     * 缺点：
     * 1. 如果始终没用到会造成浪费
     */

    private static StarvingPattern instance = new StarvingPattern();
    private StarvingPattern() {}

    public static StarvingPattern getInstance() {
        return instance;
    }
}

class SlackerPattern {
    /**
     * 懒汉模式
     * 优点：
     * 1. 类加载速度变快， 实现了延迟加载
     * 缺点：
     * 1. 使用时需要初始化，速度变慢
     * 2. 非线程安全的
     */

    private static SlackerPattern instance;

    private SlackerPattern() {}

    public static SlackerPattern getInstance() {
        if (instance == null) {
            instance = new SlackerPattern();
        }
        return instance;
    }
}

class SlackerSafePattern {
    /**
     * 线程安全的懒汉模式
     * 优点：
     * 1. 类加载速度变快，避免了不必要的浪费
     * 2. 线程安全的
     * 缺点：
     * 1. 使用时初始化，速度变慢
     * 2. 每次使用都要加锁判断，速度变慢
     */

    private static SlackerSafePattern instance;

    private SlackerSafePattern() {}

    public static synchronized SlackerSafePattern getInstance() {
        if (instance == null) {
            instance = new SlackerSafePattern();
        }
        return instance;
    }
}

class SlackerDCLPattern {
    /**
     * 双重检查模式
     * 优点：
     * 1. 类加载速度变快，避免了不必要的浪费
     * 2. 线程安全的
     * 3. 避免了不必要的线程同步
     * 缺点：
     * 1. 增大了开销
     */
    private volatile static SlackerDCLPattern instance;

    private SlackerDCLPattern() {}

    public static SlackerDCLPattern getInstance() {
        if (instance == null) {
            synchronized (SlackerDCLPattern.class) {
                if (instance == null) {
                    instance = new SlackerDCLPattern();
                }
            }
        }
        return instance;
    }
}

class StaticClassPattern {
    /**
     * 静态内部类模式
     * 优点：
     * 1. 保证了线程安全
     * 2. 使用时才回加载
     */

    private StaticClassPattern() {}

    private static StaticClassPattern getInstance() {
        return SingleHolder.intance;
    }

    private static class SingleHolder {
        private static final StaticClassPattern intance = new StaticClassPattern();
    }
}

enum  EnumPattern {
    INSTANCE;
}

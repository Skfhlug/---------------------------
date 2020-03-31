package java.edu.team.persistence;

public class SessionFactoryProvider {
    private static SessionFactory sessionFactory;

    /**
     * private constructor prevents instantiating this class anywhere else
     */

    private SessionFactoryProvider() {

    }
    /**
     * Create session factory.
     */
    public static void createSessionFactory() {

        StandardServiceRegistry standardRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        Metadata metaData =
                new MetadataSources(standardRegistry).getMetadataBuilder().build();
        sessionFactory = metaData.getSessionFactoryBuilder().build();
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory;

    }
}

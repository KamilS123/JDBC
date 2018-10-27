package pl.sdacademy.jdbc.utils;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
    private RunDao runDao;
    private Member memberDao;

    public DaoProvider() {
        this.runDao = runDao;
        this.memberDao = memberDao;
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public void setRunDao(RunDao runDao) {
        this.runDao = runDao;
    }

    public Member getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(Member memberDao) {
        this.memberDao = memberDao;
    }
}

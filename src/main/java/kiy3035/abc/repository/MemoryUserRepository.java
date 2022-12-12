


                                        // 메모리에서만 저장되는 페이지 //




//package kiy3035.abc.repository;
//
//import kiy3035.abc.domain.User1;
//
//import java.util.*;
//
//
//public class MemoryUserRepository implements UserRepository {
//
//    private static Map<Long, User1> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    @Override
//    public User1 save(User1 user) {
//        user.setIdx(++sequence);
//        store.put(user.getIdx(), user);
//        return user;
//    }
//
//    @Override
//    public Optional<User1> findById(Long idx) {
//        return Optional.ofNullable(store.get(idx));
//    }
//
//    @Override
//    public Optional<User1> findByName(String user_name) {
//        return store.values().stream()
//                .filter(user -> user.getUser_name().equals(user_name))
//                .findAny();
//    }
//
//
//    @Override
//    public List<User1> findAll() {
//
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//
//
//}

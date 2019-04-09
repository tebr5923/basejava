import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        boolean isExist = false;
        if (r.uuid != null) {
            if (size == 0) {
                storage[size] = r;
                size++;
            } else {
                // смотрим есть ли уже такой элeмент
                for (int i = 0; i < size; i++) {
                    if (storage[i].uuid.equals(r.uuid)) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    storage[size] = r;
                    size++;
                }

            }

        }
    }

    Resume get(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int k = i; k < size; k++) {
                    storage[k] = storage[k + 1];
                }
                size--;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}

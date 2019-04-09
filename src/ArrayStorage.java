import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        if (size != 0) {
            for (int a = 0; a < size; a++) {
                storage[a] = null;
            }
            size = 0;
        }
    }

    void save(Resume r) {
        boolean isExist = false;
        if (r.uuid != null) {
            if (size == 0) {
                storage[size] = r;
                size++;
            } else {
                // смотрим есть ли уже такой элeмент
                for (int a = 0; a < size; a++) {
                    if (storage[a].uuid == r.uuid) {
                        isExist = true;
                    }
                }
                if (isExist == false) {
                    storage[size] = r;
                    size++;
                }

            }

        }
    }

    Resume get(String uuid) {
        if (size != 0) {
            for (int a = 0; a < size; a++) {
                if (storage[a].uuid == uuid)
                    return storage[a];
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (size != 0) {
            for (int a = 0; a < size; a++) {
                if (storage[a].uuid == uuid) {
                    for (int k = a; k < size; k++) {
                        storage[k] = storage[k + 1];
                    }
                    size--;
                }
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

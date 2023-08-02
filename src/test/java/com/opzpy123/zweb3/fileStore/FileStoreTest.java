package com.opzpy123.zweb3.fileStore;

import com.opzpy123.zweb3.web.model.ActUser;
import com.opzpy123.zweb3.web.model.FileInfo;
import com.opzpy123.zweb3.web.service.ActUserService;
import com.opzpy123.zweb3.core.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FileStoreTest {
    @Autowired
    StoreService storeService;
    @Autowired
    ActUserService actUserService;

    @Test
    public void test() {
        List<ActUser> list = actUserService.list();
        FileInfo fileInfo = storeService.doCreateFile("allUsers", "所有用户信息", list);
        FileInfo loadFileInfo = storeService.doLoadFileInfo(fileInfo.getId());
        Object o = storeService.doLoadFileData(loadFileInfo.getFileStorePath());
        System.out.println(o);
    }
}

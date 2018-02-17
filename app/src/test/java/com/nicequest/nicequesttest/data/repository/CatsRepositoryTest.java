package com.nicequest.nicequesttest.data.repository;

import com.nicequest.nicequesttest.data.network.bodies.Data;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatsRepositoryTest {
    private TestObserver<ResponseImgur> testObserver = new TestObserver<>();

    @Mock
    CatsRepository catsRepository;

    private Data data;

    @Before
    public void setUp() throws Exception {
        data = new Data("title", new ArrayList<>());
    }


    @Test public void emptyTest() {
        catsRepository.getByPage(1);
    }

    @Test
    public void getByPageTest() throws Exception {
        Mockito.when(catsRepository.getByPage(Mockito.anyInt())).thenReturn(Observable.just(new ResponseImgur(data, true, 200 )));
        Observable<ResponseImgur> responseImgurObservable = catsRepository.getByPage(Mockito.anyInt());
        responseImgurObservable.subscribe(testObserver);
    }

    @Test
    public void statusResponseTest() throws Exception {
        Mockito.when(catsRepository.getByPage(1)).thenReturn(Observable.just(new ResponseImgur(data, true, 200 )));
        ResponseImgur responseImgur = catsRepository.getByPage(1).blockingFirst();
        assertEquals(responseImgur.getStatus(), 200);
    }
}

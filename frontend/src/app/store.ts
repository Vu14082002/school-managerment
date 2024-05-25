import { configureStore } from '@reduxjs/toolkit';
import authReducer from '../features/auth/authSlice';
import userReducer from '../features/user/userSlice';
import classDetailsReducer from '../modules/registerCourse/features/classDetails/classDetailsSlice';
import classesReducer from '../modules/registerCourse/features/classes/classesSlice';
import registeredClassesReducer from '../modules/registerCourse/features/registeredClasses/registeredClassesSlice';
import subjectsReducer from '../modules/registerCourse/features/subjects/subjectsSlice';

export const store = configureStore({
    reducer: {
        auth: authReducer,
        subjects: subjectsReducer,
        classes: classesReducer,
        user: userReducer,
        classDetails: classDetailsReducer,
        registeredClasses: registeredClassesReducer,
    },
});

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>;
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch;

import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import axios, { CancelToken } from 'axios';
import { SUBJECT_ENDPOINT } from '../../constants';
import { ICourseNeedRegister, IGetSubjects } from '../../interfaces';

interface SubjectsState {
    subjects: ICourseNeedRegister[];
    hocKy: string;
    namHoc: number;
    isLoading: boolean;
    error: string | null;
}

const initialState: SubjectsState = {
    subjects: [],
    hocKy: '',
    namHoc: 0,
    isLoading: false,
    error: null,
};

const getSubjects = createAsyncThunk(
    'getSubjects',
    async ({ data, cancelToken }: { data: IGetSubjects; cancelToken?: CancelToken }) => {
        const res = await axios.get(`${SUBJECT_ENDPOINT}/DangKyHocPhan/DotDangKy/DanhSachHocPhan`, {
            params: data,
            cancelToken,
        });

        return res.data.data;
    },
);

const subjectsSlice = createSlice({
    name: 'subjects',
    initialState,
    reducers: {
        excludeRegisteredSubject: (state, { payload }: { payload: string }) => {
            state.subjects = state.subjects.filter((subject) => subject.maHocPhan !== payload);
        },
        setHocKyVaNamHoc: (state, { payload }: { payload: { hocKy: string; namHoc: number } }) => {
            state.hocKy = payload.hocKy;
            state.namHoc = payload.namHoc;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(getSubjects.pending, (state) => {
            state.isLoading = true;
            state.error = null;
        });

        builder.addCase(getSubjects.fulfilled, (state, action) => {
            state.isLoading = false;
            state.subjects = action.payload || [];
        });

        builder.addCase(getSubjects.rejected, (state, action) => {
            state.isLoading = false;
            state.error = action.error.message || 'Cannot get subjects';
        });
    },
});

export default subjectsSlice.reducer;
export const { excludeRegisteredSubject, setHocKyVaNamHoc } = subjectsSlice.actions;
export { getSubjects };

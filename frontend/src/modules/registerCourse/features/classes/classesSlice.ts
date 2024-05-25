import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { CancelToken } from 'axios';
import axiosClient from '../../../../api';
import { SUBJECT_ENDPOINT } from '../../constants';
import { IClass, ICourseNeedRegister, IGetClasses } from '../../interfaces';

interface ClassesState {
    subject?: ICourseNeedRegister;
    classes: IClass[];
    isLoading: boolean;
    error: string | null;
}

const initialState: ClassesState = {
    classes: [],
    error: null,
    isLoading: false,
    subject: undefined,
};

const getClasses = createAsyncThunk(
    'getClasses',
    async ({ data, cancelToken }: { data: IGetClasses; cancelToken?: CancelToken }) => {
        const res = await axiosClient.get(
            `${SUBJECT_ENDPOINT}/DangKyHocPhan/DotDangKy/DanhSachHocPhan/LopHocPhanChoDangKy`,
            {
                params: data,
                cancelToken,
            },
        );
        return res.data.data;
    },
);

const classesSlice = createSlice({
    name: 'classes',
    initialState,
    reducers: {
        setSubject: (state, { payload }: { payload: ICourseNeedRegister | undefined }) => {
            state.subject = payload;
            state.classes = [];
            state.error = null;
            state.isLoading = false;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(getClasses.pending, (state) => {
            state.isLoading = true;
            state.error = null;
        });

        builder.addCase(getClasses.fulfilled, (state, action) => {
            state.isLoading = false;
            state.classes = action.payload;
        });

        builder.addCase(getClasses.rejected, (state, action) => {
            state.isLoading = false;
            state.error = action.error.message || 'Cannot get classes';
        });
    },
});

export default classesSlice.reducer;
export const { setSubject } = classesSlice.actions;
export { getClasses };

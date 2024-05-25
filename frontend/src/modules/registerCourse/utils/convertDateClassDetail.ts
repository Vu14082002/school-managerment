const datePattern = /\+(\d{8})/g;

const convertDate = (dateStr: string): string => {
    const year = dateStr.substring(0, 4);
    const month = dateStr.substring(4, 6);
    const day = dateStr.substring(6, 8);

    return `${day}/${month}/${year}`;
};

const convertDateClassDetail = (inputStr: string) => {
    const dates = inputStr.match(datePattern)?.map((date) => date.substring(1)) || [];

    const startDate = convertDate(dates[0]);
    const endDate = convertDate(dates[1]);

    const outputStr = `${startDate} - ${endDate}`;

    return outputStr;
};

export default convertDateClassDetail;

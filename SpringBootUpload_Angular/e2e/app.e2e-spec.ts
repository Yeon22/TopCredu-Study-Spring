import { Angular4UploadPage } from './app.po';

describe('angular4-upload App', () => {
  let page: Angular4UploadPage;

  beforeEach(() => {
    page = new Angular4UploadPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
